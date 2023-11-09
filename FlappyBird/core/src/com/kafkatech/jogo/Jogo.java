package com.kafkatech.jogo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.math.Rectangle;

import java.util.Random;

public class Jogo extends ApplicationAdapter {

	//Texturas
	private SpriteBatch batch;
	private Texture[] passaros;
	private Texture fundo;
	private Texture canoBaixo;
	private Texture canoTopo;
	private Texture gameOver;

	//Formas para colisão
	private ShapeRenderer shapeRenderer;
	private Circle circuloPassaro;
	private Rectangle retanguloCanoCima;
	private Rectangle retanguloCanoBaixo;

	//Configurações
	private float larguraDispotivo;
	private float alturaDispotivo;
	private float variacao = 0;
	private float gravidade = 0;
	private float posicaoPassaroY = 0;
	private float posicaoCanoX;
	private float posicaoCanoY;
	private float espacoEntreCanos;
	private Random random;
	private int pontos = 0;
	private int pontuacaoMaxima = 0;
	private boolean passouCano;
	private int estadoJogo = 0;
	private float possicaoHorizontalPassaro = 0;

	//Exibição de textos
	BitmapFont textoPontuacao;
	BitmapFont textoReiniciar;
	BitmapFont textoMelhorPontuacao;

	//Configura os sons
	Sound somVoando;
	Sound somColisao;
	Sound somPontuacao;

	//Objeto salvar pontuação
	Preferences preferences;


	@Override
	public void create () {
		//Gdx.app.log("create", "Jogo iniciado");

		inicializarTexturas();
		inicializarObjetos();
	}

	@Override
	public void render () {
		verificarEstadoJodo();
		validarPontos();
		desenharTexturas();
		detectarColisoes();
	}

	/*
	*	0 - Jogo inicial, passaro parado
	* 	1 - Começa o jogo
	* 	2 - Colidiu
	 */

	private void verificarEstadoJodo(){
		boolean toqueTela = Gdx.input.justTouched();

		if(estadoJogo == 0){
			/*Aplica evento de toque de tela*/
			if(toqueTela){
				gravidade = -14;
				estadoJogo = 1;
				somVoando.play();
			}
		}
		else if(estadoJogo == 1) {

			/*Aplica evento de toque de tela*/
			if(toqueTela){
				gravidade = -14;
				somVoando.play();
			}

			/*Movimenta o cano*/
			posicaoCanoX -= Gdx.graphics.getDeltaTime() * 200;
			if(posicaoCanoX < -canoBaixo.getWidth()){
				posicaoCanoX = larguraDispotivo;
				posicaoCanoY = random.nextInt(400) - 200;
				passouCano = false;
			}

			/* Aplica gravidade no pássaro */
			if(posicaoPassaroY > 0 || toqueTela) {
				posicaoPassaroY = posicaoPassaroY - gravidade;
			}

			gravidade++;
		}
		else if(estadoJogo == 2){
			/*
			if(posicaoPassaroY > 0 || toqueTela) {
				posicaoPassaroY = posicaoPassaroY - gravidade;
			}
			gravidade++;*/

			//
			if(pontos > pontuacaoMaxima){
				pontuacaoMaxima = pontos;
				preferences.putInteger("pontuacaoMaxima", pontuacaoMaxima);
			}
			possicaoHorizontalPassaro -= Gdx.graphics.getDeltaTime() * 500;

			if(toqueTela){
				estadoJogo = 0;
				pontos = 0;
				gravidade = 0;
				possicaoHorizontalPassaro = 0;
				posicaoPassaroY = alturaDispotivo / 2;
				posicaoCanoX = larguraDispotivo;
			}
		}
	}

	private void detectarColisoes() {
			circuloPassaro.set(50 + possicaoHorizontalPassaro + passaros[0].getWidth()/ 2, posicaoPassaroY + passaros[0].getHeight() / 2, passaros[0].getWidth()/2);
			retanguloCanoBaixo.set(
					posicaoCanoX, alturaDispotivo / 2 - canoBaixo.getHeight() - espacoEntreCanos / 2 + posicaoCanoY,
					canoBaixo.getWidth(), canoBaixo.getHeight());

			retanguloCanoCima.set(
					posicaoCanoX, alturaDispotivo / 2 + espacoEntreCanos / 2 + posicaoCanoY,
					canoTopo.getWidth(), canoTopo.getHeight());

			boolean colidiuCanoCima = Intersector.overlaps(circuloPassaro, retanguloCanoCima);
			boolean colidiuCanoBaixo = Intersector.overlaps(circuloPassaro, retanguloCanoBaixo);

			if(colidiuCanoCima || colidiuCanoBaixo){
				Gdx.app.log("Log", "Colidiu");
				if(estadoJogo == 1) {
					somColisao.play();
					estadoJogo = 2;
				}
			}


			/* USADO PARA CRIAR FORMAS
			shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
			shapeRenderer.setColor(Color.RED);

			shapeRenderer.circle(50 + passaros[0].getWidth()/ 2, posicaoPassaroY + passaros[0].getHeight() / 2, passaros[0].getWidth()/2);

			//Cano topo
			shapeRenderer.rect(
					posicaoCanoX, alturaDispotivo / 2 + espacoEntreCanos / 2 + posicaoCanoY,
					canoTopo.getWidth(), canoTopo.getHeight()
			);

			//Cano baixo
			shapeRenderer.rect(
					posicaoCanoX, alturaDispotivo / 2 - canoBaixo.getHeight() - espacoEntreCanos / 2 + posicaoCanoY,
					canoBaixo.getWidth(), canoBaixo.getHeight()
			);

			shapeRenderer.end();*/
	}

	private void desenharTexturas(){
		batch.begin();

		batch.draw(fundo, 0, 0, larguraDispotivo, alturaDispotivo);
		batch.draw(passaros[(int) variacao], 50 + possicaoHorizontalPassaro, posicaoPassaroY);

		batch.draw(canoTopo, posicaoCanoX, alturaDispotivo / 2 + espacoEntreCanos / 2 + posicaoCanoY);
		batch.draw(canoBaixo, posicaoCanoX, alturaDispotivo / 2 - canoBaixo.getHeight() - espacoEntreCanos / 2 + posicaoCanoY);

		//DESENHA O TEXTO
		textoPontuacao.draw(batch, String.valueOf(pontos), larguraDispotivo / 2, alturaDispotivo - 110);

		if(estadoJogo == 2){
			float posicaoGameOver = larguraDispotivo / 2 - gameOver.getWidth() / 2;

			batch.draw(gameOver, posicaoGameOver, alturaDispotivo / 2);
			textoReiniciar.draw(batch, "Toque para reiniciar!", larguraDispotivo / 2 - 140, alturaDispotivo / 2 - gameOver.getHeight() / 2);
			textoMelhorPontuacao.draw(batch, "Seu recorde é: " + pontuacaoMaxima + " pontos", larguraDispotivo / 2 - 140, alturaDispotivo / 2 - gameOver.getHeight());
		}

		batch.end();
	}

	private void inicializarTexturas(){
		passaros = new Texture[3];
		passaros[0] = new Texture("passaro1.png");
		passaros[1] = new Texture("passaro2.png");
		passaros[2] = new Texture("passaro3.png");

		fundo = new Texture("fundo.png");

		canoBaixo = new Texture("cano_baixo_maior.png");
		canoTopo = new Texture("cano_topo_maior.png");
		gameOver = new Texture("game_over.png");
	}

	private void inicializarObjetos(){
		batch = new SpriteBatch();
		random = new Random();

		larguraDispotivo = Gdx.graphics.getWidth();
		alturaDispotivo = Gdx.graphics.getHeight();
		posicaoPassaroY = alturaDispotivo / 2;
		posicaoCanoX = larguraDispotivo;
		espacoEntreCanos = 250;

		//Configuração dos textos
		textoPontuacao = new BitmapFont();
		textoPontuacao.setColor(Color.WHITE);
		textoPontuacao.getData().setScale(10);

		textoReiniciar = new BitmapFont();
		textoReiniciar.setColor(Color.GREEN);
		textoReiniciar.getData().setScale(2);

		textoMelhorPontuacao = new BitmapFont();
		textoMelhorPontuacao.setColor(Color.RED);
		textoMelhorPontuacao.getData().setScale(2);

		//Formas geométricas para colisões
		shapeRenderer = new ShapeRenderer();
		circuloPassaro = new Circle();
		retanguloCanoCima = new Rectangle();
		retanguloCanoBaixo = new Rectangle();

		//Inicializa sons
		somVoando = Gdx.audio.newSound(Gdx.files.internal("som_asa.wav"));
		somColisao = Gdx.audio.newSound(Gdx.files.internal("som_batida.wav"));
		somPontuacao = Gdx.audio.newSound(Gdx.files.internal("som_pontos.wav"));

		//Configura preferências dos objetos
		preferences = Gdx.app.getPreferences("flappBird");
		pontuacaoMaxima = preferences.getInteger("pontuacaoMaxima", 0);
	}

	private void validarPontos() {
		if(posicaoCanoX < 50 - passaros[0].getWidth()){//Passou da posição do passaro
			if(!passouCano){
				pontos++;
				passouCano = true;
				somPontuacao.play();
			}
		}

		/* Verifica variação para bater asas do pássaro*/
		variacao += Gdx.graphics.getDeltaTime() * 10;
		if(variacao > 3) {
			variacao = 0;
		}
	}
	
	@Override
	public void dispose () {

	}
}

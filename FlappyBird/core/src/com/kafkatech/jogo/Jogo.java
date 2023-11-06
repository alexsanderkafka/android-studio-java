package com.kafkatech.jogo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Random;

public class Jogo extends ApplicationAdapter {

	//Texturas
	private SpriteBatch batch;
	private Texture[] passaros;
	private Texture fundo;
	private Texture canoBaixo;
	private Texture canoTopo;

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
	private boolean passouCano;

	//Exibição de textos
	BitmapFont textoPontuacao;


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
	}


	private void verificarEstadoJodo(){

		/*Movimenta o cano*/
		posicaoCanoX -= Gdx.graphics.getDeltaTime() * 200;
		if(posicaoCanoX < -canoBaixo.getWidth()){
			posicaoCanoX = larguraDispotivo;
			posicaoCanoY = random.nextInt(400) - 200;
			passouCano = false;
		}
		/*Aplica evento de toque de tela*/
		boolean toqueTela = Gdx.input.justTouched();
		if(toqueTela){
			gravidade = -14;
		}

		/* Aplica gravidade no pássaro */
		if(posicaoPassaroY > 0 || toqueTela) {
			posicaoPassaroY = posicaoPassaroY - gravidade;
		}

		variacao += Gdx.graphics.getDeltaTime() * 10;

		/* Verifica variação para bater asas do pássaro*/
		if(variacao > 3) {
			variacao = 0;
		}

		gravidade++;
	}

	private void desenharTexturas(){
		batch.begin();

		batch.draw(fundo, 0, 0, larguraDispotivo, alturaDispotivo);
		batch.draw(passaros[(int) variacao], 50, posicaoPassaroY);

		batch.draw(canoBaixo, posicaoCanoX, alturaDispotivo / 2 - canoBaixo.getHeight() - espacoEntreCanos / 2 + posicaoCanoY);
		batch.draw(canoTopo, posicaoCanoX, alturaDispotivo / 2 + espacoEntreCanos / 2 + posicaoCanoY);

		//DESENHA O TEXTO
		textoPontuacao.draw(batch, String.valueOf(pontos), larguraDispotivo / 2, alturaDispotivo - 110);

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

		//Configuração dos textos
		textoPontuacao = new BitmapFont();
		textoPontuacao.setColor(Color.WHITE);
		textoPontuacao.getData().setScale(10);
	}

	private void inicializarObjetos(){
		batch = new SpriteBatch();
		random = new Random();

		larguraDispotivo = Gdx.graphics.getWidth();
		alturaDispotivo = Gdx.graphics.getHeight();

		posicaoPassaroY = alturaDispotivo / 2;

		posicaoCanoX = larguraDispotivo;

		espacoEntreCanos = 200;
	}

	private void validarPontos() {
		if(posicaoCanoX < 50 - passaros[0].getWidth()){//Passou da posição do passaro
			if(!passouCano){
				pontos++;
				passouCano = true;
			}
		}
	}
	
	@Override
	public void dispose () {

	}
}

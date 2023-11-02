package com.kafkatech.jogo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
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


	@Override
	public void create () {
		//Gdx.app.log("create", "Jogo iniciado");

		inicializarTexturas();
		inicializarObjetos();
	}

	@Override
	public void render () {
		verificarEstadoJodo();

		desenharTexturas();
	}

	private void verificarEstadoJodo(){

		/*Movimenta o cano*/
		posicaoCanoX -= Gdx.graphics.getDeltaTime() * 200;
		if(posicaoCanoX < -canoBaixo.getWidth()){
			posicaoCanoX = larguraDispotivo;
			posicaoCanoY = random.nextInt(400) - 200;
		}
		/*Aplica evento de toque de tela*/
		boolean toqueTela = Gdx.input.justTouched();
		if(toqueTela){
			gravidade = -20;
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
		batch.draw(passaros[(int) variacao], 30, posicaoPassaroY);

		batch.draw(canoBaixo, posicaoCanoX, alturaDispotivo / 2 - canoBaixo.getHeight() - espacoEntreCanos / 2 + posicaoCanoY);
		batch.draw(canoTopo, posicaoCanoX, alturaDispotivo / 2 + espacoEntreCanos / 2 + posicaoCanoY);

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
	
	@Override
	public void dispose () {

	}
}

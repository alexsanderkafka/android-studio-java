package com.kafkatech.jogo;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.ScreenUtils;

public class Jogo extends ApplicationAdapter {

	private int movimentoX = 0;
	private int movimentoY = 0;
	private SpriteBatch batch;
	private Texture[] passaros;
	private Texture fundo;

	//Configurações
	private float larguraDispotivo;
	private float alturaDispotivo;
	private float variacao = 0;
	private float gravidade = 0;
	private float posicaoPassaroY = 0;


	@Override
	public void create () {
		//Gdx.app.log("create", "Jogo iniciado");

		batch = new SpriteBatch();

		passaros = new Texture[3];

		passaros[0] = new Texture("passaro1.png");
		passaros[1] = new Texture("passaro2.png");
		passaros[2] = new Texture("passaro3.png");
		fundo = new Texture("fundo.png");

		larguraDispotivo = Gdx.graphics.getWidth();
		alturaDispotivo = Gdx.graphics.getHeight();

		posicaoPassaroY = alturaDispotivo / 2;
	}

	@Override
	public void render () {
		batch.begin();

		if(variacao > 3) {
			variacao = 0;
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
		batch.draw(fundo, 0, 0, larguraDispotivo, alturaDispotivo);
		batch.draw(passaros[(int) variacao], 30, posicaoPassaroY);

		variacao += Gdx.graphics.getDeltaTime() * 10;

		gravidade++;
		movimentoX++;
		movimentoY++;

		batch.end();
	}
	
	@Override
	public void dispose () {

	}
}

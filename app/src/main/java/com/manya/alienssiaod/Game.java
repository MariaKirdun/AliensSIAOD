package com.manya.alienssiaod;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Game extends Activity implements View.OnClickListener {

	private GameView gameView;

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.game_activity);

		gameView = findViewById(R.id.gameView);
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		Maze maze = (Maze) extras.get("maze");
		gameView.setMaze(this, maze);

		Button btnUp = findViewById(R.id.btnUp);
		btnUp.setOnClickListener(this);
		Button btnDown = findViewById(R.id.btnDown);
		btnDown.setOnClickListener(this);
		Button btnRight = findViewById(R.id.btnRight);
		btnRight.setOnClickListener(this);
		Button btnLeft = findViewById(R.id.btnLeft);
		btnLeft.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		gameView.onStep(v.getId());
	}
}

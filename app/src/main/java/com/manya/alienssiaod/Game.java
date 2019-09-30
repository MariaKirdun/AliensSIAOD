package com.manya.alienssiaod;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class Game extends Activity {

	public void onCreate(Bundle bundle) {
		super.onCreate(bundle);
		setContentView(R.layout.game_activity);

		GameView gameView = findViewById(R.id.gameView);
		Intent intent = getIntent();
		Bundle extras = intent.getExtras();
		Maze maze = (Maze) extras.get("maze");
		gameView.setMaze(this, maze);
	}

}

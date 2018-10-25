package com.blevast.motion.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.annotation.NonNull;

//This is trial view model
public class ScoreCarView extends ViewModel {

    private int teamScoreA;
    private int teamScoreB;
    private String name;


    public ScoreCarView(String name){
        this.name = name;
    }

    public int getTeamScoreA() {
        return teamScoreA;
    }

    public int getTeamScoreB() {
        return teamScoreB;
    }

    public void setTeamScoreA(int teamScoreA) {
        this.teamScoreA = teamScoreA;
    }

    public void setTeamScoreB(int teamScoreB) {
        this.teamScoreB = teamScoreB;
    }
}

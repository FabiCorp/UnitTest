package com.unittester.game;

import com.badlogic.gdx.scenes.scene2d.Event;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 *
 * Game State Logic
 *     GameState                         Actions Processed              New State
 *        SelectNextUnitGameState
 *                                       UnitBuildButtonAction          PlaceUnitInCityGameState
 *
 *                                       FightButtonAction              FightGameStateNoUnitSelected
 *
 *
 *                                       ActiveUnitButtonAction         no Change
 *                                       (SP:deletes unit in city/army
 *                                        MP:not available)
 *        PlaceUnitInCityGameState
 *                                       PlaceUnitInCityButtonAction
 *                                       (places unit in city/army)
 *                                                                      SP: SelectNextUnitGameState
 *                                                                      MP: WaitForOtherPlayer
 *
 *        FightGameStateNoUnitSelected
 *                                       ActiveUnitButtonAction         FightGameStateUnitSelected
 *                                       FightButtonAction
 *                                       (fight over, not implemented)
 *                                                                      SelectNextUnitGameState
 *        FightGameStateUnitSelected
 *                                       ActiveUnitButtonAction
 *                                       (here the fight takes place)   SP: FightGameStateNoUnitSelected
 *                                                                      MP: WaitForOtherPlayer
 *
 *        WaitForOtherPlayer (MP Only)
 *                                       PlaceUnitInCityButtonAction    PlaceUnitInCityGameState
 *                                       ActiveUnitButtonAction         FightGameStateNoUnitSelected
 *                                       FightButtonAction              FightGameStateNoUnitSelected
 *
 */
public abstract class GameState {
    GameState() {
        System.out.println("Switching to GameState: " + this.getClass());
    }
    abstract void respond(GameAction action);
}


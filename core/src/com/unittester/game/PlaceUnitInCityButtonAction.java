package com.unittester.game;

import com.unittester.game.network.ConnectionManager;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class PlaceUnitInCityButtonAction extends GameAction {
    int cityNumber;
    int player;
    UnitType unitType;
    public PlaceUnitInCityButtonAction(int cityNumber, int player) {
        super();
        this.cityNumber = cityNumber;
        this.player = player;

    }

    @Override
    void doAction(State state) {
        if (state instanceof PlaceUnitInCityState) {
            UnitBuildButtonAction unitBuildButtonAction = ((PlaceUnitInCityState) state).getPrevious();
            System.out.println("Place Army " + unitBuildButtonAction.getUt() +
                    " player: " + player + " in city " + cityNumber);

            unitType = unitBuildButtonAction.getUt();
            // send
            placeUnit();
            Globals.connectionManager.sendData(this);
            if (Globals.singlePlayer)
                Globals.gameState = new SelectNextUnitState();
            else
                Globals.gameState = new WaitForNextUnitState();
        } else if (state instanceof WaitForNextUnitState) {
            placeUnit();
            Globals.gameState = new SelectNextUnitState();
        }

    }

    private void placeUnit() {
        ArmyContainer armyContainer = Globals.armyContainers[player];
        Army army = armyContainer.get(cityNumber);
        Unit unit = army.addUnit(unitType);
        ActiveUnitButton activeUnitButton = new ActiveUnitButton(unit, player, cityNumber);
        armyContainer.horizontalGroups.get(cityNumber).addActor(activeUnitButton);
    }
}

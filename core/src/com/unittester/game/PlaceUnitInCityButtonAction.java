package com.unittester.game;
import java.io.Serializable;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class PlaceUnitInCityButtonAction extends GameAction implements Serializable {
    int cityNumber;
    int player;
    UnitType unitType;
    static final long serialVersionUID = 42L;

    public PlaceUnitInCityButtonAction(int cityNumber, int player) {
        super();
        this.cityNumber = cityNumber;
        this.player = player;

    }

    @Override
    void doAction(GameState gameState) {
        if (gameState instanceof PlaceUnitInCityGameState) {
            UnitBuildButtonAction unitBuildButtonAction = ((PlaceUnitInCityGameState) gameState).getPrevious();
            unitType = unitBuildButtonAction.getUt();
            placeUnit();

            Globals.connectionManager.sendData(this);

            Globals.gameGameState = new WaitForOtherPlayerGameState();

        } else if (gameState instanceof WaitForOtherPlayerGameState) {
            if (!Globals.singlePlayer)
                placeUnit();
            Globals.gameGameState = new SelectNextUnitGameState();
        }
    }

    private void placeUnit() {
        System.out.println("Place Army " + unitType +
                " player: " + player + " in city " + cityNumber);
        ArmyContainer armyContainer = Globals.armyContainers[player];
        Army army = armyContainer.get(cityNumber);
        Unit unit = army.addUnit(unitType);
        ActiveUnitButton activeUnitButton = new ActiveUnitButton(unit, player, cityNumber);
        armyContainer.horizontalGroups.get(cityNumber).addActor(activeUnitButton);
    }
}

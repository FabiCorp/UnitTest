package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class PlaceUnitInCityButtonAction extends GameAction {
    int cityNumber;
    int player;
    public PlaceUnitInCityButtonAction(int cityNumber, int player) {
        super();
        this.cityNumber = cityNumber;
        this.player = player;
    }

    @Override
    void doAction(State state) {
        assert (state instanceof PlaceUnitInCityState);
        UnitBuildButtonAction unitBuildButtonAction = ((PlaceUnitInCityState) state).getPrevious();
        System.out.println("Place Army " + unitBuildButtonAction.getUt() +
                " player: " + player + " in city " + cityNumber);
        ArmyContainer armyContainer = Globals.armyContainers[player];
        Army army = armyContainer.get(cityNumber);
        Unit unit = army.addUnit(unitBuildButtonAction.getUt());

        ActiveUnitButton activeUnitButton = new ActiveUnitButton(unit,player, cityNumber);
        armyContainer.horizontalGroups.get(cityNumber).addActor(activeUnitButton);
        Globals.gameState = new SelectNextUnitState();

    }
}

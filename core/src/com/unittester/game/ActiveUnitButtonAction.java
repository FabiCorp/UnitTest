package com.unittester.game;

/**
 * Created by Wolfgang Wenzel on 02.07.2017.
 * Copyright Wolfgang Wenzel
 */
public class ActiveUnitButtonAction extends GameAction {
        ActiveUnitButton button;
        Unit unit;
        int player;
        int city;
        public ActiveUnitButtonAction(ActiveUnitButton button, Unit unit, int player, int city)
        {
            this.city = city;
            this.button = button;
            this.unit   = unit;
            this.player = player;
        }

        public void doAction(GameState gameState){

            if (gameState instanceof PlaceUnitInCityGameState) {
                ArmyContainer armyContainer = Globals.armyContainers[player];
                Army army = armyContainer.get(city);
                army.remove(unit);
                armyContainer.horizontalGroups.get(city).removeActor(button);
                Globals.gameGameState = new SelectNextUnitGameState();
            } else if (gameState instanceof FightGameStateNoUnitSelected) {
                Globals.gameGameState = new FightGameStateUnitSelected(this);
            } else if (gameState instanceof FightGameStateUnitSelected){
                ActiveUnitButtonAction other = ((FightGameStateUnitSelected) gameState).firstUnit;
                System.out.println("Fighting Player " + player + " City " + city + " Unit: " + unit.getType() +
                " with player " + other.player + " City " + other.city + " Unit " + other.unit.getType());

                if (unit.doDamage(other.unit) <= 0) {
                    System.out.println("First unit Dead");
                    ArmyContainer armyContainer = Globals.armyContainers[player];
                    Army army = armyContainer.get(city);
                    army.remove(unit);
                    armyContainer.horizontalGroups.get(city).removeActor(button);
                }
                button.setText(unit.getType() + " " + unit.getTotalDefensePoiints());
                if (other.unit.doDamage(unit) <= 0) {
                    ArmyContainer armyContainer = Globals.armyContainers[other.player];
                    Army army = armyContainer.get(other.city);
                    army.remove(other.unit);
                    armyContainer.horizontalGroups.get(other.city).removeActor(other.button);
                    System.out.println("2nd unit dead");
                }
                other.button.setText(other.unit.getType() + " " + other.unit.getTotalDefensePoiints());


                Globals.gameGameState = new FightGameStateNoUnitSelected();
            }



        }


        public int getPlayer() {
            return player;
        }
    }


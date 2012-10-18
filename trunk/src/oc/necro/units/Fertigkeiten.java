package oc.necro.units;

import oc.BuildaHQ;
import oc.RuestkammerStarter;
import oc.RuestkammerVater;

public class Fertigkeiten extends RuestkammerVater {

    String[] namen = {
        "Geschick", "Nahkampf", "Wildheit", "St‰rke", "Schieﬂen", "Verstohlenheit", "Technik", "Territorienfertigkeiten"
    };
    RuestkammerStarter[] rk = new RuestkammerStarter[namen.length];

//    int[][][] darf = {
//        {{1,1,1,1,1,0,1},{0,0,1,1,1,0,1},{1,1,1,0,0,0,0},{0,1,1,0,0,0,0}},
//        {{1,1,1,0,1,1,1},{1,0,0,1,1,0,1},{1,1,0,0,0,1,0},{1,1,0,0,0,0,0}},
//        {{1,1,1,0,1,1,1},{0,0,0,1,1,1,1},{1,0,0,0,1,1,0},{0,0,0,0,1,1,0}},
//        {{0,1,1,1,1,1,1},{0,1,0,1,1,0,1},{0,1,1,1,0,0,0},{0,0,1,1,0,0,0}},
//        {{1,1,1,0,1,1,1},{0,1,0,1,1,0,1},{0,1,1,0,1,0,0},{0,0,1,0,1,0,0}},
//        {{1,1,1,0,1,1,1},{0,1,0,1,1,0,1},{0,1,0,0,1,0,1},{0,0,0,0,1,0,1}},
//    };

    int kategorie;
    int volk;
	
	public Fertigkeiten() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
//        kategorie = BuildaHQ.boolZuZahl(defaults);
//        volk = this.volkZuInt();

        for (int i = 0; i < rk.length; i++) {
//            if(darf[volk][kategorie][i] == 1) {
                rk[i] = new RuestkammerStarter(ID, randAbstand, cnt, BuildaHQ.formZuKlassenName(namen[i]), "", 1);
                rk[i].initKammer(true);
                rk[i].setButtonText(namen[i]);
                rk[i].setName(namen[i]);
                rk[i].setUeberschriftTrotzNullKostenAusgeben(true);
                add(rk[i]);
//            }
        }
        
		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

//    private int volkZuInt() {
//        String volk1 = OnlineCodex.getInstance().getCurrentArmy();
//        int i = 0;
//        return volk1.equals(this.cawdor) ? 0 : volk1.equals(this.delaque) ? 1 : volk1.equals(this.escher) ? 2 : volk1.equals(this.goliath) ? 3 : volk1.equals(this.orlock) ? 4 : volk1.equals(this.vansaar) ? 5 : 0;
//    }

}

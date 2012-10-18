package oc.wh40k.units.ec;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OnlineCodex;
import oc.RuestkammerStarter;

public class ECShadowSpectres extends Eintrag {

    AnzahlPanel squad;
    RuestkammerStarter rkBoss;

    public ECShadowSpectres() {
        name = "Shadow Spectres Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;
        
        add(squad = new AnzahlPanel(ID, randAbstand, cnt, "Shadow Spectres", 3, 6, 35));
        seperator();

        add(ico = new oc.Picture("oc/wh40k/images/ECShadowSpectres.jpg"));
        
        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ECExarch", "Upgrade to Exarch");
		rkBoss.initKammer();
		add(rkBoss);
        
        if(OnlineCodex.getInstance().getCurrentArmy().equals("EldarCorsairsIA11")) {
            BuildaHQ.addToInformationVector("ECEldarAllies", 1);
        }

        complete();
    }

    @Override
    public void refreshen() {
        if(OnlineCodex.getInstance().getCurrentArmy().equals("EldarCorsairsIA11")) {
            if(BuildaHQ.getCountFromInformationVector("ECEldarAllies") > 1) {
                setFehlermeldung("Eldar-Alliierte > 1!");
            } else {
                setFehlermeldung("");
            }
        }
    }
    
    @Override
    public void deleteYourself() {
        if(OnlineCodex.getInstance().getCurrentArmy().equals("EldarCorsairsIA11")) {
            BuildaHQ.addToInformationVector("ECEldarAllies", -1);
        }
    }

}

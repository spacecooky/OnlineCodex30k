package oc.wh40k.units.ec;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ECWaspAssaultWalkerSquadron extends Eintrag {

    OptionsEinzelUpgrade oe1;
    RuestkammerStarter w1;
    RuestkammerStarter w2;
    RuestkammerStarter w3;

    public ECWaspAssaultWalkerSquadron() {
        name = "Wasp Assault Walker Squadron";
        grundkosten = 0;
        überschriftSetzen = true;
        
        BuildaHQ.addToInformationVector("ECWaspAssaultWalkerSquadron", 1);

        add(ico = new oc.Picture("oc/wh40k/images/ECWaspAssaultWalkerSquadron.jpg"));

        seperator();

        add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Spirit Stones", 5));
        
        seperator();

        w1 = new RuestkammerStarter(ID, randAbstand, cnt, "ECWaspAssaultWalkerKammer", "Wasp");
        w1.initKammer();
        add(w1);

        w2 = new RuestkammerStarter(ID, randAbstand, cnt, "ECWaspAssaultWalkerKammer", "Wasp");
        w2.initKammer();
        add(w2);

        w3 = new RuestkammerStarter(ID, randAbstand, cnt, "ECWaspAssaultWalkerKammer", "Wasp");
        w3.initKammer();
        add(w3);

        complete();
    }

    @Override
    public void refreshen() {
        int walkers = (w1.isSelected() ? 1 : 0) + (w2.isSelected() ? 1 : 0) + (w3.isSelected() ? 1 : 0);

        oe1.setPreis(walkers * 5);
        oe1.setAktiv(walkers > 0);
        
        int corsairSquads = BuildaHQ.getCountFromInformationVector("ECCorsairSquad");
        int waspSquads = BuildaHQ.getCountFromInformationVector("ECWaspAssaultWalkerSquadron");
        
        if(waspSquads > corsairSquads) {
            setFehlermeldung("Wasp Squads > " + corsairSquads + "!");
        } else {
            setFehlermeldung("");
        }
    }
    
    @Override
    public void deleteYourself() {
        BuildaHQ.addToInformationVector("ECWaspAssaultWalkerSquadron", -1);
    }
    
}

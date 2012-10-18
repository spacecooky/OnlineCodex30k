package oc.wh40k.units.ec;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;

public class ECCorsairJetbikeSquadron extends Eintrag {

    AnzahlPanel squad;
    OptionsEinzelZaehler oz1;
    RuestkammerStarter rkBoss;

    public ECCorsairJetbikeSquadron() {
        name = "Corsair Jetbike Squadron\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Corsairs", 3, 10, 25);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ECCorsairJetbikeSquadron.jpg"));
        
        seperator();

        add(oz1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Shuriken Cannon", 1, 10));
        
        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ECFelarch", "Upgrade to Felarch");
		rkBoss.initKammer(false);
		add(rkBoss);
        
        complete();
    }

    @Override
    public void refreshen() {
        oz1.setMaxAnzahl( squad.getModelle() / 3 );
    }
    
}

package oc.wh40k.units.ec;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ECHarlequinTroupe extends Eintrag {

    AnzahlPanel squad;
    OptionsEinzelZaehler oz1;
    OptionsEinzelZaehler oz2;
    OptionsUpgradeGruppe boss;
    RuestkammerStarter rkViper;

    public ECHarlequinTroupe() {
        name = "Harlequin Troupe\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Harlequin", 5, 10, 18);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ECHarlequinTroupe.jpg"));
        
        seperator();

        add(oz1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Harlequin's Kiss", 5, 4));
        
        seperator();
        
        add(oz2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Fusion Pistol", 2, 10));
        
        seperator();
        
        ogE.addElement(new OptionsGruppeEintrag("Shadowseer", "Upgrade to Shadowseer", 30));
        ogE.addElement(new OptionsGruppeEintrag("Death Jester", "Upgrade to Death Jester", 10));
        ogE.addElement(new OptionsGruppeEintrag("Master w/ Power Weapin", "Upgrade to Troupe Master with Power Weapon", 20));
        ogE.addElement(new OptionsGruppeEintrag("Master w/ Harlequin's Kiss", "Upgrade to Troupe Master with Harlequin's Kiss", 20));
        add(boss = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));
        
        seperator();

		rkViper = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairVenomKammer", "Corsair Venom");
		rkViper.initKammer();
		add(rkViper);
        
        complete();

    }

    @Override
    public void refreshen() {
        oz1.setMaxAnzahl(squad.getModelle() - boss.getAnzahl());
        
        rkViper.setAktiv(squad.getModelle() == 5); 
    }
    
}

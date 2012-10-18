package oc.wh40k.units.ec;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ECCorsairSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsEinzelUpgrade jetpacks;
    RuestkammerStarter rkBoss;
    RuestkammerStarter rkViper;
    RuestkammerStarter rkFalcon;

    public ECCorsairSquad() {
        name = "Corsair Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;
        
        BuildaHQ.addToInformationVector("ECCorsairSquad", 1);

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Corsairs", 5, 10, 9);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ECCorsairSquad.jpg"));
        
        seperator();
        
		ogE.addElement(new OptionsGruppeEintrag("Flamer", 6));
		ogE.addElement(new OptionsGruppeEintrag("Fusion Gun", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        
        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Shuriken Cannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Eldar Missile Launcher", 15));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));
        
        seperator();
        
        add(jetpacks = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Corsair Jet Packs", 25));
        
        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ECFelarch", "Upgrade to Felarch");
		rkBoss.initKammer(true);
		add(rkBoss);
        
        seperator();

		rkViper = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairVenomKammer", "Corsair Venom");
		rkViper.initKammer();
		add(rkViper);

		rkFalcon = new RuestkammerStarter(ID, randAbstand, cnt, "ECCorsairFalconKammer", "Corsair Falcon");
		rkFalcon.initKammer();
		add(rkFalcon);
        
        complete();
    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl( squad.getModelle() / 5 );
        o2.setMaxAnzahl( squad.getModelle() / 5 );
        
        rkFalcon.setAktiv(squad.getModelle() <= 6 && !rkViper.isSelected() && !jetpacks.isSelected());
        rkViper.setAktiv(squad.getModelle() <= 5 && !rkFalcon.isSelected() && !jetpacks.isSelected());
    }
    
    @Override
    public void deleteYourself() {
        BuildaHQ.addToInformationVector("ECCorsairSquad", -1);
    }
    
}

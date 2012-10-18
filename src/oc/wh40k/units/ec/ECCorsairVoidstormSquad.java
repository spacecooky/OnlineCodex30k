package oc.wh40k.units.ec;

import oc.AnzahlPanel;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ECCorsairVoidstormSquad extends Eintrag {

    AnzahlPanel squad;
    OptionsZaehlerGruppe o1;
    RuestkammerStarter rkBoss;

    public ECCorsairVoidstormSquad() {
        name = "Corsair Voidstorm Squad\n";
        grundkosten = 0;
        überschriftSetzen = true;

        squad = new AnzahlPanel(ID, randAbstand, cnt, "Veteran Corsairs", 5, 10, 12);
        add(squad);

        add(ico = new oc.Picture("oc/wh40k/images/ECCorsairVoidstormSquad.jpg"));
        
        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flamer", 6));
		ogE.addElement(new OptionsGruppeEintrag("Fusion Pistol", 10));
		ogE.addElement(new OptionsGruppeEintrag("Fusion Gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Power Weapon", 10));
        add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        
        seperator();
        
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Haywire Grenades", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meltabombs", 15));
        
        complete();

    }

    @Override
    public void refreshen() {
        o1.setMaxAnzahl( squad.getModelle() / 3 );
    }
    
}

package oc.wh40k.units.dm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class DMMegaDread extends Eintrag {

    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    OptionsZaehlerGruppe o2e;
    OptionsZaehlerGruppe o2f;
    OptionsEinzelUpgrade o3;

	public DMMegaDread() {
		name = "Mega-Dread";
		grundkosten = 175;


		add(ico = new oc.Picture("oc/wh40k/images/MegaDread.gif"));
		

		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Big Shoota", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot Riggas", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Mega-Charga", 15));
        
        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 0));
		ogE.addElement(new OptionsGruppeEintrag("Skorcha", 0));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 5));
		ogE.addElement(new OptionsGruppeEintrag("Mega-Blasta", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Rippa Klaw", 0));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
		ogE.addElement(new OptionsGruppeEintrag("Killkannon", 0));
        add(o2e = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
        ogE.addElement(new OptionsGruppeEintrag("Supa-skorcha", 0));
        add(o2f = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator(7);


		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "twin-linked Killkannon", 35));

		complete();

	}

	public void refreshen() {
        o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());
        int weapon = o2.getAnzahl() + o2e.getAnzahl() + o2f.getAnzahl();
        o2.setLegal(weapon == 2 || o3.isSelected());
        o2e.setLegal(weapon == 2 || o3.isSelected());
        o2f.setLegal(weapon == 2 || o3.isSelected());
        o3.setLegal(weapon == 2 || o3.isSelected());
        o2.setMaxAnzahl((o2e.isSelected()||o2f.isSelected()) ? 1 : 2);
        o3.setAktiv(!o2.isSelected() && !o2e.isSelected() && !o2f.isSelected());
        o2.setAktiv(!o3.isSelected());
        o2e.setAktiv(!o3.isSelected() && !o2f.isSelected());
        o2f.setAktiv(!o3.isSelected() && !o2e.isSelected());
	}
}


package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class GKTechmarine extends Eintrag {

    OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;

	public GKTechmarine() {
		name = "Techmarine";
		grundkosten = 90;

		add(ico = new oc.Picture("oc/wh40k/images/GKTechmarine.jpg"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Bolter & Servoharnisch", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter & Servoharnisch", 3));
		ogE.addElement(new OptionsGruppeEintrag("Konversionsstrahler", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 0));
		ogE.addElement(new OptionsGruppeEintrag("Psischwert", "Nemesis-Psischwert", 5));
		ogE.addElement(new OptionsGruppeEintrag("Psihellebarde", "Nemesis-Psihellebarde", 10));
		ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Falchions", "Nemesis-Falchions", 15));
		ogE.addElement(new OptionsGruppeEintrag("Wehrstab", "Nemesis-Wehrstab", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Servo-Schädel", 3, 3));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Tarnwolkengranaten", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melterbomben", 5));
		ogE.addElement(new OptionsGruppeEintrag("Psiaktive Munition", 5));
		ogE.addElement(new OptionsGruppeEintrag("Strahlungsgranaten", 10));
		ogE.addElement(new OptionsGruppeEintrag("Empyreische Hirnminen", 10));
		ogE.addElement(new OptionsGruppeEintrag("Digitalwaffen", 15));
		ogE.addElement(new OptionsGruppeEintrag("Psigasgranaten", 15));
		ogE.addElement(new OptionsGruppeEintrag("Orbitalschlag-Relais", 50));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 100));

		complete();
	}

	@Override
	public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0, true);
        if(!o2.isSelected()) o2.setSelected(0, true);
	}

}

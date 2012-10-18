package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class GKBruderCaptainderGreyKnights extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	public GKBruderCaptainderGreyKnights() {
		name = "Bruder-Captain der Grey Knights";
		grundkosten = 150;

		add(ico = new oc.Picture("oc/wh40k/images/GKBruderCaptainderGreyKnights.jpg"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Erlöser-Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Psipulser", 30));
		ogE.addElement(new OptionsGruppeEintrag("Psibolter", 40));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Sturmbolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Erlöser-Flamer", "Meisterhafter Erlöser-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Psipulser", 35));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Psibolter", 45));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Psischwert", "Nemesis-Psischwert", 0));
		ogE.addElement(new OptionsGruppeEintrag("Psihellebarde", "Nemesis-Psihellebarde", 5));
		ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Falchions", "Paar Nemesis-Falchions", 10));
		ogE.addElement(new OptionsGruppeEintrag("Wehrstab", "Nemesis-Wehrstab", 35));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhaftes Psischwert", "Meisterhaftes Nemesis-Psischwert", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafte Psihellebarde", "Meisterhafte Nemesis-Psihellebarde", 10));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Däm.hammer", "Meisterhafter Nemesis-Dämonenhammer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafte Falchions", "Meisterhaftes Paar Nemesis-Falchions", 15));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Wehrstab", "Meisterhafter Nemesis-Wehrstab", 40));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Servo-Schädel", 3, 5));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Tarnwolkengranaten", 5));
		ogE.addElement(new OptionsGruppeEintrag("Melterbomben", 5));
		ogE.addElement(new OptionsGruppeEintrag("Digitalwaffen", 5));
		ogE.addElement(new OptionsGruppeEintrag("Psiaktive Munition", 5));
		ogE.addElement(new OptionsGruppeEintrag("Empyreische Hirnminen", 10));
		ogE.addElement(new OptionsGruppeEintrag("Psigasgranaten", 15));
		ogE.addElement(new OptionsGruppeEintrag("Strahlungsgranaten", 15));
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

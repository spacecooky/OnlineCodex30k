package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class GKScriptor extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	public GKScriptor() {
		name = "Scriptor";
		grundkosten = 150;

		add(ico = new oc.Picture("oc/wh40k/images/GKGrossmeisterderGGKScriptorreyKnights.jpg"));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meisterschaftsgrad 3", 50));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Sturmbolter", 5));
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

		ogE.addElement(new OptionsGruppeEintrag("Psiaktive Munition", 5));
		ogE.addElement(new OptionsGruppeEintrag("Digitalwaffen", 5));
		ogE.addElement(new OptionsGruppeEintrag("Empyreische Hirnminen", 10));
		ogE.addElement(new OptionsGruppeEintrag("Teleport-Peilsender", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 100));

		seperator();

		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Servo-Schädel", 3, 5));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Exzision", 5));
		ogE.addElement(new OptionsGruppeEintrag("Gedankenschnell", 5));
		ogE.addElement(new OptionsGruppeEintrag("Titans Macht", 5));
		ogE.addElement(new OptionsGruppeEintrag("Zuflucht", 5));
		ogE.addElement(new OptionsGruppeEintrag("Schmetterschlag", 5));
		ogE.addElement(new OptionsGruppeEintrag("Schleier", 5));
		ogE.addElement(new OptionsGruppeEintrag("Herbeirufung", 5));
		ogE.addElement(new OptionsGruppeEintrag("Vortex der Verdammnis", 5));
		ogE.addElement(new OptionsGruppeEintrag("Warpriss", 5));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 100));

		complete();
	}

	@Override
	public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0, true);
        if(!o2.isSelected()) o2.setSelected(0, true);
	}

}

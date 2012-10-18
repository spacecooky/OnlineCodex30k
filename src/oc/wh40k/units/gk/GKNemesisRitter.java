package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class GKNemesisRitter extends Eintrag {

	OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	public GKNemesisRitter() {
		name = "Nemesis-Ritter";
		grundkosten = 130;

		add(ico = new oc.Picture("oc/wh40k/images/GKNemesisRitter.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("2 x Nemesis-Bannfaust", 0));
		ogE.addElement(new OptionsGruppeEintrag("1 x Nemesis-Bannfaust", "Nemesis-Bannfaust", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Nemesis-Dämonenhammer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Nemesis-Langschwert", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Erlöser-Flamer", "Schwerer Erlöser-Flammenwerfer", 30));
		ogE.addElement(new OptionsGruppeEintrag("Schnellfeuer-Psipulser", 35));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Psibolter", 40));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Teleportmodul", 75));

		complete();
	}

	@Override
	public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0, true);

        o2.setAktiv(o1.isSelected("Nemesis-Bannfaust"));
        
        if(!o2.isSelected() && o1.isSelected("Nemesis-Bannfaust")) o2.setSelected(0, true);
	}

}

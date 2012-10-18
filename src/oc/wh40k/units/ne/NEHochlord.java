package oc.wh40k.units.ne;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class NEHochlord extends Eintrag {

	OptionsUpgradeGruppe o1;
    RuestkammerStarter rkTransport;

	public NEHochlord() {
		name = "Hochlord";
		grundkosten = 90;

		BuildaHQ.addToInformationVector("NEHochlord", 1);

		add(ico = new oc.Picture("oc/wh40k/images/NEHochlord.jpg"));
		
		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Aufwertung zum Phaeron", 20));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Stab des Lichts", 0));
		ogE.addElement(new OptionsGruppeEintrag("Hyperphasenschwert", 0));
		ogE.addElement(new OptionsGruppeEintrag("Flammenfaust", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kriegssense", 10));
		ogE.addElement(new OptionsGruppeEintrag("Entropieklinge", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Phylakterium", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gedankenkontrollskarabäen", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Durasempisches Geflecht", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tesserakt-Labyrinth", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Tachyonenpfeil", 30));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Regeneratorsphäre", 30));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Phasenverzerrer", 45));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "NEKommandogleiterKammer", "Kommando-Gleiter");
		rkTransport.initKammer();
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0, true);
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("NEHochlord", -1);
		super.deleteYourself();
	}

}

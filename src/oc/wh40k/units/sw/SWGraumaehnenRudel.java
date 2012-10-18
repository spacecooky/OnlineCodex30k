package oc.wh40k.units.sw;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class SWGraumaehnenRudel extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	RuestkammerStarter rkTransport;
	RuestkammerStarter rkPod;

	public SWGraumaehnenRudel() {
		name = "Graumähnen-Rudel\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Graumähnen", 5, 10, 15);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/SWGraumaehnenrudel.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 5, 5));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 10, 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 0));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plasma-Pistole", 15));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Wolfsbanner", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "1 x Mal des Wulfen", 15));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "SWTransporterKammer", "Transportfahrzeug");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transportfahrzeug");
		add(rkTransport);

		seperator();

		rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "SWDropPodKammer", "Landungskapsel");
		rkPod.initKammer(false);
		rkPod.setButtonText("Landungskapsel");
		rkPod.setSeperator(0);
		add(rkPod);

		complete();
	}

	@Override
	public void refreshen() {
		o2.setAktiv(squad.getModelle() == 10 && o1.isSelected());

		rkTransport.setAktiv(!rkPod.isSelected());
		rkPod.setAktiv(!rkTransport.isSelected());
	}

}

package oc.wh40k.units.sw;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class SWBlutwolfRudel extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;

	RuestkammerStarter rkTransport;
	RuestkammerStarter rkPod;

	OptionsEinzelUpgrade lukas;

	boolean lukasSelected = false;

	public SWBlutwolfRudel() {
		name = "Blutwolf-Rudel\n";
		grundkosten = 0;
		überschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Blutwölfe", 5, 15, 15);
		add(squad);

		seperator();

		add(ico = new oc.Picture("oc/wh40k/images/SWBlutwolfrudel.jpg"));

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

		add(lukas = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Lukas der Listenreiche", "Upgrade zu Lukas der Listenreiche", 140));

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
		// Unique entry: Lukas der Listenreiche
		boolean lukasGlobal = ( BuildaHQ.getCountFromInformationVector("SWLukas") > 0 ? true : false );
		if(lukasGlobal && !lukasSelected) lukas.setAktiv(false);
		else lukas.setAktiv(true);

		if(lukas.isSelected()) {
			lukasSelected = true;
			BuildaHQ.addToInformationVector("SWLukas", 1);
		} else {
			if(lukasSelected) {
				lukasSelected = false;
				BuildaHQ.setInformationVectorValue("SWLukas", 0);
				BuildaHQ.refreshEntries(3);
			}
		}

		o2.setAktiv(squad.getModelle() == 15);

		rkTransport.setAktiv(!rkPod.isSelected());
		rkPod.setAktiv(!rkTransport.isSelected());
	}

}

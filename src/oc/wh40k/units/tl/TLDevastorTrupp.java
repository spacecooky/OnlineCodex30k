package oc.wh40k.units.tl;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TLDevastorTrupp extends Eintrag {

	AnzahlPanel squad;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkTransport;
	RuestkammerStarter rkPod;

	public TLDevastorTrupp() {
		name = "Devastor-Trupp\n";
		grundkosten = 0;
		überschriftSetzen = true;
		
		BuildaHQ.addToInformationVector("TLSupport", 1);

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Space Marines", 5, 10, 16);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMDevastatorTrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 25));
		ogE.addElement(new OptionsGruppeEintrag("Laserkanone", 35));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "TLSergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer(true, true, false, false);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "TLTransporterKammer", "Transporter");
		rkTransport.initKammer(false, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		seperator();

		rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "TLDropPodKammer", "Landungskapsel");
		rkPod.initKammer(false);
		rkPod.setButtonText("Landungskapsel");
		rkPod.setSeperator(0);
		add(rkPod);

		complete();
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("TLSupport", -1);
		super.deleteYourself();
	}
	
	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		rkTransport.setAktiv(!rkPod.isSelected());
		rkPod.setAktiv(!rkTransport.isSelected());
		
		int selectedSquads = BuildaHQ.getCountFromInformationVector("TLSupport");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("TLEnableHeavySupport");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("SM-Unterstützung > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
	}

}

package oc.wh40k.units.tl;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class TLTerminatorTrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsEinzelZaehler o2;
	RuestkammerStarter rkRaider;

	boolean raiderSelected = false;

	public TLTerminatorTrupp() {
		name = "Terminator-Trupp\n";
		grundkosten = 0;
		überschriftSetzen = true;

		BuildaHQ.addToInformationVector("TLElite", 1);
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, "Terminatoren", 5, 10, 40);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/SMTerminatorTrupp.jpg"));

		seperator(12);

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 30));
		ogE.addElement(new OptionsGruppeEintrag("Cyclone Raketenwerfer", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		seperator(8);

		add(o2 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Kettenfaust", -88, 5));

		seperator();

		rkRaider = new RuestkammerStarter(ID, randAbstand, cnt, "TLLandRaiderKammer", "Land Raider");
		rkRaider.initKammer(false);
		rkRaider.setButtonText("Land Raider");
		add(rkRaider);

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle() / 5);
		o2.setMaxAnzahl(squad.getModelle() - 1);

		// Unique entry: Land Raider
		boolean raiderGlobal = ( BuildaHQ.getCountFromInformationVector("TLTermiRaider") > 0 ? true : false );
		if(raiderGlobal && !raiderSelected) rkRaider.setAktiv(false);
		else rkRaider.setAktiv(true);

		if(rkRaider.isSelected()) {
			raiderSelected = true;
			BuildaHQ.addToInformationVector("TLTermiRaider", 1);
		} else {
			if(raiderSelected) {
				raiderSelected = false;
				BuildaHQ.setInformationVectorValue("TLTermiRaider", 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
		int selectedSquads = BuildaHQ.getCountFromInformationVector("TLElite");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("TLEnableHonourGuard");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("SM-Eliteauswahlen > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		if(raiderSelected) {
			BuildaHQ.setInformationVectorValue("TLTermiRaider", 0);
		}
		BuildaHQ.addToInformationVector("TLElite", -1);
		super.deleteYourself();
	}

}

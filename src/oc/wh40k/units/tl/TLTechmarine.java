package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class TLTechmarine extends Eintrag {

	RuestkammerStarter rkServitor;

	public TLTechmarine() {
		name = "Techmarine";
		grundkosten = 50;

		BuildaHQ.addToInformationVector("TLElite", 1);
		
		add(ico = new oc.Picture("oc/wh40k/images/Techmarine.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Servoharnisch", 25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Energiewaffe", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Energiehammer", 30));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Space Marine Bike", 35));

		seperator();

		rkServitor = new RuestkammerStarter(ID, randAbstand, cnt, "TLServitorKammer", "Servitoren");
		rkServitor.initKammer();
		rkServitor.setButtonText("Servitoren");
		add(rkServitor);

		complete();
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("TLElite", -1);
		super.deleteYourself();
	}
	
	@Override
	public void refreshen() {
		int selectedSquads = BuildaHQ.getCountFromInformationVector("TLElite");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("TLEnableHonourGuard");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("SM-Eliteauswahlen > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
	}
}

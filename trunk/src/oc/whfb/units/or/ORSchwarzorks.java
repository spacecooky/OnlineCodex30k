package oc.whfb.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ORSchwarzorks extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBanner;
	
	boolean oberHartnSelected = false;
	OptionsEinzelUpgrade oberHartnOption;
	
	public ORSchwarzorks() {
		name = BuildaHQ.translate("Schwarzorks");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Schwarzorks"), 10, 100, 12);
		squad.setGrundkosten(0);
		add(squad);

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schilde"), 1));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Champion"), 15));

		seperator();
		
		add(oberHartnOption = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Ober Hart'n"), 0, false));
		
		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "ORBanner", "");
		rkBanner.initKammer(true, false, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle());
		rkBanner.setAktiv(oeS.isSelected());	
		
		/*if (ico != null ) panel.remove(ico);
		//if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
		
		if ( BuildaHQ.getCountFromInformationVector("GRIMGORK") != 0 ){
			// Unique entry: OberHartn
			boolean oberHartn = ( BuildaHQ.getCountFromInformationVector("OBERHARTN") > 0 ? true : false );
			if(oberHartn && !oberHartnSelected) oberHartnOption.setAktiv(false);
			else oberHartnOption.setAktiv(true);
	
			if(oberHartnOption.isSelected()) {
				oberHartnSelected = true;
				BuildaHQ.setInformationVectorValue("OBERHARTN", 1);
			} else {
				if(oberHartnSelected) {
					oberHartnSelected = false;
					BuildaHQ.setInformationVectorValue("OBERHARTN", 0);
					BuildaHQ.refreshEntries(2);
				}
			}
		} else {
			oberHartnOption.setAktiv(false);
		}
	}
	
	@Override
	public void deleteYourself() {
		if(oberHartnSelected) {
			BuildaHQ.setInformationVectorValue("OBERHARTN", 0);
		}
		super.deleteYourself();
	}
}

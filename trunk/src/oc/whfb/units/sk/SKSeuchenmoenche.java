package oc.whfb.units.sk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class SKSeuchenmoenche extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;	
	RuestkammerStarter rkBanner;
	OptionsUpgradeGruppe o1;
	boolean astSelected = false;

	public SKSeuchenmoenche() {
		name = BuildaHQ.translate("Seuchenmönche");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Seuchenmönche"), 10, 100, 7);
		squad.setGrundkosten(0);
		add(squad);

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 5));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));

		seperator();
		
		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "SKBanner", "");
		rkBanner.initKammer(true, true, false, true);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		// Unique entry: AST
		boolean astGlobal = ( BuildaHQ.getCountFromInformationVector("SEUCHENMOENCHE STANDARTE") > 0 ? true : false );
		if(astGlobal && !astSelected) rkBanner.setAktiv(false);
		else rkBanner.setAktiv(oeS.isSelected());

		if(rkBanner.isSelected()) {
			astSelected = true;
			BuildaHQ.setInformationVectorValue("SEUCHENMOENCHE STANDARTE", 1);
		} else {
			if(astSelected) {
				astSelected = false;
				BuildaHQ.setInformationVectorValue("SEUCHENMOENCHE STANDARTE", 0);
				BuildaHQ.refreshEntries(2);
			}
		}
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
		
		if ( getKategorie() == 4){
			try {
				setUnikat(true, Integer.valueOf(budget.getText()).intValue() >= 3000 ? 6 : 3);
			} catch (Exception e){
				setUnikat(true, 3);
			}
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		
		if(astSelected) {
			BuildaHQ.setInformationVectorValue("SEUCHENMOENCHE STANDARTE", 0);
		}
	}
}

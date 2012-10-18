package oc.whfb.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class ORWildorkWildschweinreiter extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBanner;
	boolean moschazSel = false;
	
	public ORWildorkWildschweinreiter() {
		name = BuildaHQ.translate("Wildork-Wildschweinreiter");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Wildork-Wildschweinreiter"), 5, 100, 18);
		squad.setGrundkosten(0);
		add(squad);

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Upgrade zu Moschaz"), 8));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zwei Handwaffen"), 2));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Speere"), 2));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schilde"), 2));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Champion"), 15));

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
		oe1.setPreis(squad.getModelle() * 4);
		oe2.setPreis(squad.getModelle() * 2);
		o1.setPreis(0, squad.getModelle() * 2);
		o1.setPreis(1, squad.getModelle() * 2);

		rkBanner.setAktiv(oeS.isSelected());	

		if ( BuildaHQ.getCountFromInformationVector("GORBAD") == 0 ) {
			// Unique entry: Moschaz
			boolean moschGlobal = ( BuildaHQ.getCountFromInformationVector("MOSCHAZ") > 0 ? true : false );
			if(moschGlobal && !moschazSel) oe1.setAktiv(false);
			else oe1.setAktiv(true);
	
			if(oe1.isSelected()) {
				moschazSel = true;
				BuildaHQ.setInformationVectorValue("MOSCHAZ", 1);
			} else {
				if(moschazSel) {
					moschazSel = false;
					BuildaHQ.setInformationVectorValue("MOSCHAZ", 0);
					BuildaHQ.refreshEntries(2);
				}
			}
		}
		
		/*if (ico != null ) panel.remove(ico);
		//if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
	
	@Override
	public void deleteYourself() {
		if(moschazSel) {
			moschazSel = false;
			BuildaHQ.setInformationVectorValue("MOSCHAZ", 0);
		}
		
		super.deleteYourself();
	}
}

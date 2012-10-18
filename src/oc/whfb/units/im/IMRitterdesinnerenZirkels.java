package oc.whfb.units.im;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class IMRitterdesinnerenZirkels extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBanner;
	OptionsUpgradeGruppe o1;
	
	public IMRitterdesinnerenZirkels() {
		name = BuildaHQ.translate("Ritter des inneren Zirkels");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Ritter des inneren Zirkels"), 5, 100, 26);
		squad.setGrundkosten(0);
		add(squad);

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Lanzen"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffen"), 0));		
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 8));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 16));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 16));

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "IMBanner", "");
		rkBanner.initKammer(true, true, false, true);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);
		
		complete();
	}

	@Override
	public void refreshen() {
		rkBanner.setAktiv(oeS.isSelected());
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
		
		try {
			setUnikat(true, Integer.valueOf(budget.getText()).intValue() >= 3000 ? 6 : 3);
		} catch (Exception e){
			setUnikat(true, 3);
		}
	}
}

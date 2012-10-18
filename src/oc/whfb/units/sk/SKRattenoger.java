package oc.whfb.units.sk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class SKRattenoger extends Eintrag {

	AnzahlPanel squad;
	AnzahlPanel squad2;

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	
	OptionsEinzelUpgrade oe1;
	RuestkammerStarter rkBoss;
	
	public SKRattenoger() {
		name = BuildaHQ.translate("Rattenoger");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Rattenoger"), 2, 100, 40);		
		squad.setGrundkosten(0);
		add(squad);
		
		squad2 = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Meutenb�ndiger"), 1, 100, 8);		
		squad2.setGrundkosten(0);
		squad2.setNichtDieErsteOption(true);
		add(squad2);
		
		seperator();
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Elite-Rattenoger"), 15));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Champion"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kwietsch Nagzahn"), 100));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Dingf�nger"), 20));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SKMagicItems", "");
		rkBoss.initKammer(false, true, false, false, false, false, false, true);
		rkBoss.setButtonText(BuildaHQ.translate("Magische Gegenst�nde"));
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		complete();
	}

	@Override
	public void refreshen(){
		squad2.setMaxModelle( 1 + (squad.getModelle()/2) );
		
		rkBoss.setAktiv(o1.isSelected(BuildaHQ.translate("Champion")));
		o2.setAktiv(o1.isSelected(BuildaHQ.translate("Champion")));
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 60);
			panel.add(ico); }*/
		
		try {
			setUnikat(true, Integer.valueOf(budget.getText()).intValue() >= 3000 ? 6 : 3);
		} catch (Exception e){
			setUnikat(true, 3);
		}
	}
}

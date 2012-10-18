package oc.whfb.units.sk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class SKRiesenratten extends Eintrag {

	AnzahlPanel squad;
	AnzahlPanel squad2;
	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	
	RuestkammerStarter rkBoss;
	
	public SKRiesenratten() {
		name = BuildaHQ.translate("Riesenratten");
		grundkosten = 0;
		
		setCountToMinimum(false); // Unit cannot resolve minimum number of core units

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Riesenratten"), 5, 100, 3);		
		squad.setGrundkosten(0);
		add(squad);
		
		squad2 = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Meutenbändiger"), 1, 100, 8);		
		squad2.setGrundkosten(0);
		squad2.setNichtDieErsteOption(true);
		add(squad2);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Champion"), 25));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kwietsch Nagzahn"), 100));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Dingfänger"), 20));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "SKMagicItems", "");
		rkBoss.initKammer(false, true, false, false, false, false, false, true);
		rkBoss.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		complete();
	}

	@Override
	public void refreshen(){
		squad2.setMaxModelle( 1 + (squad.getModelle()/5) );
		
		rkBoss.setAktiv(o1.isSelected(BuildaHQ.translate("Champion")));
		o2.setAktiv(o1.isSelected(BuildaHQ.translate("Champion")));
		
		if(BuildaHQ.getCountFromInformationVector("SK_SKROTZ") != 0){
			setCountToMinimum(true); 
		}else{
			setCountToMinimum(false); 
		}
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 60);
			panel.add(ico); }*/
	}	
}

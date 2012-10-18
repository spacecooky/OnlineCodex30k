package oc.whfb.units.bdc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class BDCMinotauren extends Eintrag {

	RuestkammerStarter rkBoss;
	AnzahlPanel squad;
	
	OptionsUpgradeGruppe o2;
	
	OptionsEinzelUpgrade oeC;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeM;
	
	public BDCMinotauren() {
		name = BuildaHQ.translate("Minotauren");
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Minotauren"), 3, 100, 55);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffen"), 8));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("zus. Handwaffen"), 4));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schilde"), 4));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 20));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 20));

		seperator();
		
		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "BDCMagicItems", "");
		rkBoss.initKammer(false, false, false, true);
		rkBoss.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		
		complete();
	}

	@Override
	public void refreshen() {
		o2.setPreis(0, squad.getModelle() * 8);
		o2.setPreis(1, squad.getModelle() * 4);
		o2.setPreis(2, squad.getModelle() * 4);
		
		rkBoss.setAktiv(oeC.isSelected());
	}
}

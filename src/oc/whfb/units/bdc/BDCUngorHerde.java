package oc.whfb.units.bdc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class BDCUngorHerde extends Eintrag {

	AnzahlPanel squad;
	
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe1;
	
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeM;

	public BDCUngorHerde() {
		name = BuildaHQ.translate("Ungor Herde");
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Ungor Herde"), 10, 100, 5);
		squad.setGrundkosten(0);
		add(squad);
		
		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));
		
		seperator();
		
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Speere"), 1));
		
		
		seperator();
		
		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 3));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 6));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Champion"), 6));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ungrol"), 75));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);
	}
}

package oc.whfb.units.bdc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class BDCGorHerde extends Eintrag {

	AnzahlPanel squad;
	
	OptionsUpgradeGruppe o1;
	
	OptionsEinzelUpgrade oeC;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeM;

	public BDCGorHerde() {
		name = BuildaHQ.translate("Gor Herde");
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Gor Herde"), 10, 100, 7);
		squad.setGrundkosten(0);
		add(squad);
		
		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schild"), 1));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("zus. Handwaffen"), 1));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();
		
		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 5));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));
		
		complete();
	}

	@Override
	public void refreshen() {
		o1.setPreis(0,squad.getModelle() * 1);
		o1.setPreis(1,squad.getModelle() * 1);
	}
}

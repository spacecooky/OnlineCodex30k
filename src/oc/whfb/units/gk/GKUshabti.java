package oc.whfb.units.gk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class GKUshabti extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	
	public GKUshabti() {
		name = BuildaHQ.translate("Ushabti");
		grundkosten = 0;
                
                add(ico = new oc.Picture(this));
                
                seperator();

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Ushabti"), 3, 100, 50);
		squad.setGrundkosten(0);
		add(squad);
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zweihandwaffe"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("zus. Handwaffe"), 0));		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Großbögen"), 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);
		
		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));
		
		complete();
	}
	@Override
	public void refreshen() {
//		/*if (ico != null ) panel.remove(ico);
//		if ( BuildaMenu.bilderAneigen.isSelected() ) {
//			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
//			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
//			panel.add(ico);
//		}
	}
}

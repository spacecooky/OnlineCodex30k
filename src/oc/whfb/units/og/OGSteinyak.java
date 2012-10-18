package oc.whfb.units.og;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class OGSteinyak extends Eintrag {

	OptionsUpgradeGruppe o1;
	
	public OGSteinyak() {
		name = BuildaHQ.translate("Steinyak");
		grundkosten = 250;
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Ketten-Fangeisen"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Harpunenschleuder"), 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, false));
		o1.setSelected(0, true);

		complete();
	}

	@Override
	public void refreshen() {
		o1.alwaysSelected();
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((250 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
		
		try {
			setUnikat(true, Integer.valueOf(budget.getText()).intValue() >= 3000 ? 4 : 2);
		} catch (Exception e){
			setUnikat(true, 2);
		}
	}
}

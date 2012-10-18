package oc.whfb.units.im;

import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;

public class IMLudwigSchwarzhelm extends Eintrag {
	
	public IMLudwigSchwarzhelm() {
		name = BuildaHQ.translate("Ludwig Schwarzhelm");
		grundkosten = 220;

		BuildaHQ.setInformationVectorValue("IMast", 1);
		
		complete();
	}

	@Override
	public void refreshen() {
		int sigmar = BuildaHQ.getCountFromInformationVector("IM_SIGMAR");
		if(sigmar == 0){
			BuildaHQ.getChooserGruppe(3).removeSpezialAuswahl(BuildaHQ.translate("Kern Flagellanten"));
			BuildaHQ.refreshEntries(3);
		}
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
		
		setUnikat(true);
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.setInformationVectorValue("IMast", 0);
		super.deleteYourself();
	}
}

package oc.whfb.units.sk;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.BuildaMenu;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;

public class SKSchattenlaeufer extends Eintrag {

	AnzahlPanel squad;

	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	
	boolean weapon = false;
	OptionsUpgradeGruppe o1;
	
	public SKSchattenlaeufer() {
		name = BuildaHQ.translate("Schattenläufer");
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Schattenläufer"), 10, 100, 7);
		squad.setGrundkosten(0);
		add(squad);

		seperator();
		
		add(oe1= new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schleudern"), 1));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 8));
		
		seperator();

		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Warpbohrer"), 60));
		
		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() *1);
		
		// Unique entry: Waffenteam
		boolean wtGlobal = ( BuildaHQ.getCountFromInformationVector("SKst") > 0 ? true : false );
		
		if(wtGlobal && !weapon) oe3.setAktiv(false);
		else oe3.setAktiv(true);
		
		if(oe3.getKosten() > 0){
			if(!weapon){
				BuildaHQ.setInformationVectorValue("SKst", 1);
			}
			weapon = true;
		}else{
			if(weapon){
				weapon = false;
				BuildaHQ.setInformationVectorValue("SKst", 0);
			}
		}
		
		/*if (ico != null ) panel.remove(ico);
		if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}

	@Override
	public void deleteYourself() {
		if(weapon){
			BuildaHQ.setInformationVectorValue("SKst", 0);
		}
		super.deleteYourself();
	}
}

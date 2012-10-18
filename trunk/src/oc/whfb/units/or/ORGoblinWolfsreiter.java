package oc.whfb.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORGoblinWolfsreiter extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oe3;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	
	boolean heulerzSelected = false;
	OptionsEinzelUpgrade heulerzOption;
	
	public ORGoblinWolfsreiter() {
		name = BuildaHQ.translate("Goblin-Wolfsreiter");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Goblin-Wolfsreiter"), 5, 100, 10);
		squad.setGrundkosten(0);
		add(squad);

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Speere"), 1));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Kurzbögen"), 1));

		seperator();

		add(oe3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schilde"), 1));

		seperator();
		
		add(heulerzOption = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Da Heulerz"), 0, false));
		
		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Champion"), 10));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);
		oe2.setPreis(squad.getModelle() * 1);
		oe3.setPreis(squad.getModelle() * 1);
		
		/*if (ico != null ) panel.remove(ico);
		//if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/

		if ( BuildaHQ.getCountFromInformationVector("GITTILDA") != 0 ){
			// Unique entry: OberHartn
			boolean oberHartn = ( BuildaHQ.getCountFromInformationVector("HEULERZ") > 0 ? true : false );
			if(oberHartn && !heulerzSelected) heulerzOption.setAktiv(false);
			else heulerzOption.setAktiv(true);
	
			if(heulerzOption.isSelected()) {
				heulerzSelected = true;
				BuildaHQ.setInformationVectorValue("HEULERZ", 1);
			} else {
				if(heulerzSelected) {
					heulerzSelected = false;
					BuildaHQ.setInformationVectorValue("HEULERZ", 0);
					BuildaHQ.refreshEntries(2);
				}
			}
		} else {
			heulerzOption.setAktiv(false);
		}
	}
	
	@Override
	public void deleteYourself() {
		if(heulerzSelected) {
			BuildaHQ.setInformationVectorValue("HEULERZ", 0);
		}
		super.deleteYourself();
	}
}

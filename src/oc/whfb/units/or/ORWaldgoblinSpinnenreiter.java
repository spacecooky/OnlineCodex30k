package oc.whfb.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORWaldgoblinSpinnenreiter extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	
	boolean todeskrabblazSelected = false;
	OptionsEinzelUpgrade todeskrabblazOption;
	
	public ORWaldgoblinSpinnenreiter() {
		name = BuildaHQ.translate("Waldgoblin-Spinnenreiter");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Waldgoblin-Spinnenreiter"), 5, 100, 13);
		squad.setGrundkosten(0);
		add(squad);

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Kurzbögen"), 1));

		seperator();
		
		add(todeskrabblazOption = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Todeskrabblaz"), 0, false));
		
		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Champion"), 10));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle());
		
		/*if (ico != null ) panel.remove(ico);
		//if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
			
		if ( BuildaHQ.getCountFromInformationVector("SNAGLA") != 0 ){
			// Unique entry: OberHartn
			boolean oberHartn = ( BuildaHQ.getCountFromInformationVector("TODESKRABBLAZ") > 0 ? true : false );
			if(oberHartn && !todeskrabblazSelected) todeskrabblazOption.setAktiv(false);
			else todeskrabblazOption.setAktiv(true);
	
			if(todeskrabblazOption.isSelected()) {
				todeskrabblazSelected = true;
				BuildaHQ.setInformationVectorValue("TODESKRABBLAZ", 1);
			} else {
				if(todeskrabblazSelected) {
					todeskrabblazSelected = false;
					BuildaHQ.setInformationVectorValue("TODESKRABBLAZ", 0);
					BuildaHQ.refreshEntries(2);
				}
			}
		} else {
			todeskrabblazOption.setAktiv(false);
		}
	}
	
	@Override
	public void deleteYourself() {
		if(todeskrabblazSelected) {
			BuildaHQ.setInformationVectorValue("TODESKRABBLAZ", 0);
		}
		super.deleteYourself();
	}
}

package oc.whfb.units.or;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ORWildorks extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	boolean moschazSel = false;

	public ORWildorks() {
		name = BuildaHQ.translate("Wildorks");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Wildorks"), 10, 100, 8);
		squad.setGrundkosten(0);
		add(squad);

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Upgrade zu Moschaz"), 2));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zusätzliche Handwaffen"), 1));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Speere"), 1));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Bögen"), 1));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Schilde"), 1));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Große Spizßaz"), 20));
		
		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("Champion"), 15));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 2);
		oe2.setPreis(squad.getModelle());

		o1.setPreis(0, squad.getModelle() * 1);
		o1.setPreis(1, squad.getModelle() * 1);
		o1.setPreis(2, squad.getModelle() * 1);

		if ( BuildaHQ.getCountFromInformationVector("GORBAD") == 0 ) {
			// Unique entry: Moschaz
			boolean moschGlobal = ( BuildaHQ.getCountFromInformationVector("MOSCHAZ") > 0 ? true : false );
			if(moschGlobal && !moschazSel) oe1.setAktiv(false);
			else oe1.setAktiv(true);
	
			if(oe1.isSelected()) {
				moschazSel = true;
				BuildaHQ.setInformationVectorValue("MOSCHAZ", 1);
			} else {
				if(moschazSel) {
					moschazSel = false;
					BuildaHQ.setInformationVectorValue("MOSCHAZ", 0);
					BuildaHQ.refreshEntries(2);
				}
			}
		}
		
		/*if (ico != null ) panel.remove(ico);
		//if ( BuildaMenu.bilderAneigen.isSelected() ) {
			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);
			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);
			panel.add(ico); }*/
	}
	
	@Override
	public void deleteYourself() {
		if(moschazSel) {
			moschazSel = false;
			BuildaHQ.setInformationVectorValue("MOSCHAZ", 0);
		}
		
		super.deleteYourself();
	}
}

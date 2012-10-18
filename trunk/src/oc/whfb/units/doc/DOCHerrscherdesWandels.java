package oc.whfb.units.doc;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DOCHerrscherdesWandels extends Eintrag {

	RuestkammerStarter rkMagic;
	OptionsUpgradeGruppe o1;

	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	RuestkammerStarter rkLore;

	public DOCHerrscherdesWandels() {
		name = BuildaHQ.translate("Herrscher des Wandels");
		grundkosten = 450;

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Upgrade zur 3. Stufe"), 50));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Upgrade zur 4. Stufe"), 85));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "DOCMagicItems", "");
		rkMagic.initKammer(false, true, false, false, false, false, false, false, false);
		rkMagic.setButtonText(BuildaHQ.translate("Dämonengeschenke"));
		add(rkMagic);
		
		seperator();

		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(true,false,false);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);

		complete();
	}

	@Override
	public void refreshen() {
		rkLore.getKammer().specialAction(
			!(rkMagic.getText().indexOf(BuildaHQ.translate("Meister der Zauberei")) == -1 ), false, false					
		);
		
		rkLore.setAbwaehlbar(false);
		
		// Unique entry: GENERAL
		boolean genGlobal = ( BuildaHQ.getCountFromInformationVector("Gen") > 0 ? true : false );
		if(genGlobal && !genSelected) oGen.setAktiv(false);
		else oGen.setAktiv(true);

		if(oGen.isSelected()) {
			genSelected = true;
			BuildaHQ.setInformationVectorValue("Gen", 1);
		} else {
			if(genSelected) {
				genSelected = false;
				BuildaHQ.setInformationVectorValue("Gen", 0);
				BuildaHQ.refreshEntries(2);
			}
		}
	}

	@Override
	public void deleteYourself() {
		if(genSelected) {
			BuildaHQ.setInformationVectorValue("Gen", 0);
		}
		super.deleteYourself();
	}
}

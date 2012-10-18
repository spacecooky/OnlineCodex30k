package oc.whfb.units.doc;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DOCHueterderGeheimnisse extends Eintrag {

	RuestkammerStarter rkMagic;
	OptionsUpgradeGruppe o1;

	boolean genSelected = false;
	OptionsEinzelUpgrade oGen;
	RuestkammerStarter rkLore;

	public DOCHueterderGeheimnisse() {
		name = BuildaHQ.translate("Hüter der Geheimnisse");
		grundkosten = 450;

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));

		seperator(12);

		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Upgrade zur 2. Stufe"), 35));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Upgrade zur 3. Stufe"), 85));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Upgrade zur 4. Stufe"), 120));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		
		seperator();

		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "DOCMagicItems", "");
		rkMagic.initKammer(false, false, false, true, false, false, false, false, false);
		rkMagic.setButtonText(BuildaHQ.translate("Dämonengeschenke"));
		add(rkMagic);
		
		seperator();

		rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung + "MagicLores", "");
		rkLore.initKammer(false,false,true);
		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));
		add(rkLore);

		complete();
	}

	@Override
	public void refreshen() {
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

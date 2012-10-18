package oc.whfb.units.vf;import oc.BuildaHQ;import oc.BuildaMenu;import oc.Eintrag;import oc.OptionsEinzelUpgrade;import oc.RuestkammerStarter;		public class VFManfredderAkolyth extends Eintrag {	RuestkammerStarter rkMount;	RuestkammerStarter rkMagic;		RuestkammerStarter rkLore;	boolean genSelected = false;	OptionsEinzelUpgrade oGen;	public VFManfredderAkolyth() {		name = BuildaHQ.translate("Manfred der Akolyth");		grundkosten = 185;		seperator(12);		add(oGen = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("General"), 0, false));				seperator();		rkMagic = new RuestkammerStarter(ID, randAbstand, cnt, "VFManfredKammer", "");		rkMagic.initKammer(false);		rkMagic.setButtonText(BuildaHQ.translate("Arkane Artefakte"));		add(rkMagic);		seperator();		rkMount = new RuestkammerStarter(ID, randAbstand, cnt, "VFMount", "");		rkMount.initKammer(false, false, false, true);		rkMount.setButtonText(BuildaHQ.translate("Reittier"));		add(rkMount);				seperator();				rkLore = new RuestkammerStarter(ID, randAbstand, cnt, reflectionKennung+"MagicLores", "");		rkLore.initKammer(true,false);		rkLore.setButtonText(BuildaHQ.translate("Lehren der Magie"));		add(rkLore);		complete();	}	//@OVERRIDE	public void refreshen() {		rkLore.setAbwaehlbar(false);				// Unique entry: GENERAL		boolean genGlobal = ( BuildaHQ.getCountFromInformationVector("Gen") > 0 ? true : false );		if(genGlobal && !genSelected) oGen.setAktiv(false);		else oGen.setAktiv(true);		if(oGen.isSelected()) {			genSelected = true;			BuildaHQ.setInformationVectorValue("Gen", 1);		} else {			if(genSelected) {				genSelected = false;				BuildaHQ.setInformationVectorValue("Gen", 0);				BuildaHQ.refreshEntries(2);			}		}				/*if (ico != null ) panel.remove(ico);		if ( BuildaMenu.bilderAneigen.isSelected() ) {			ico = BuildaHQ.createPictureJLabel(BuildaHQ.IMAGEPFAD + reflectionKennung.toLowerCase() + "/" + getClass().getSimpleName() + JPG);			ico.setLocation((290 - (ico.getSize().width - 100) / 2), 30);			panel.add(ico);		} */				setUnikat(true);	}		@Override	public void deleteYourself() {		if(genSelected) {			BuildaHQ.setInformationVectorValue("Gen", 0);		}		super.deleteYourself();	}}
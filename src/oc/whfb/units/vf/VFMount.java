package oc.whfb.units.vf;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class VFMount extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	boolean isF�rst = false;
	boolean isVampir = false;
	boolean isNekro = false;
	boolean isFluch = false;
	boolean isManfred = false;
	boolean isNachtmahr = false;
	boolean isH�llenross = false;
	boolean isRitter = false;
        OptionsEinzelUpgrade oe1;
        OptionsEinzelUpgrade oe2;

	public VFMount() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		// defaults[0] = Vampirf�rst
		// defaults[1] = Vampir
		// defaults[2] = Fluchf�rst
		// defaults[3] = Manfred

                isF�rst = defaults[0];
                isVampir = defaults[1];
                isFluch = defaults[2];
                isManfred = defaults[3];
                isNachtmahr = (defaults[0] || defaults[1]);
                isH�llenross = (defaults[0] || defaults[1]);

		if(isF�rst || isVampir) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Nachtmahr"), isF�rst ? 20 : 8));
		if(isManfred) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Nachtmahr + Rossharnisch"), 20));
		if(isF�rst || isVampir || isManfred) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("H�llenross"), (isF�rst || isManfred) ? 30 : 20));
		if(isFluch) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Skelettpferd"), 15));
		if(isFluch) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("SP + Rossharnisch"), BuildaHQ.translate("Skelettpferd + Rossharnisch"), 20));
		if(isF�rst || isManfred) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Schrecken d. Unterwelt"), BuildaHQ.translate("Schrecken der Unterwelt"), 135));
		if(isF�rst) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Flederbestie"), 225));
		if(isF�rst) ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zombiedrache"), 275));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		setUeberschrift(BuildaHQ.translate("Reittier"));
                
                seperator();
                
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Fledermausbefall"), 10));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Fauliger Rachen"), 15));
                
		sizeSetzen(100, 100, 285, KAMMER_HOEHE + cnt + 10);
	}

	@Override
	public void refreshen() {
		//if(!o1.isSelected()) o1.setSelected(0, true);
            
                oe1.setAktiv(o1.isSelected("Flederbestie"));
                oe2.setAktiv(o1.isSelected("Flederbestie"));

		if(isRitter) {
			o1.setPreis(BuildaHQ.translate("Nachtmahr"), 0);
			o1.alwaysSelected();
		}
		else {
			o1.setPreis(BuildaHQ.translate("Nachtmahr"), isF�rst ? 20 : 8);
		}
	}

	@Override
	public void switchEntry(String entry, boolean state) {
		if(entry.equals(BuildaHQ.translate("Ritter der Nacht"))) {
			this.isRitter = state;
		}
	}
}


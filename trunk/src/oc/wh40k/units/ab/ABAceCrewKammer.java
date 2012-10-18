package oc.wh40k.units.ab;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class ABAceCrewKammer extends RuestkammerVater {

    OptionsUpgradeGruppe o1;

    boolean slickLoader = true;
    boolean multiple = false;

	public ABAceCrewKammer() {
		grundkosten = 0;
	}

    @Override
	public void initButtons(boolean... defaults) {
//        if(defaults.length > 0) {
//            this.multiple = defaults[0];
//        }
        if(defaults.length > 0) {
           this.slickLoader = defaults[0];
        }

		ogE.addElement(new OptionsGruppeEintrag("Skilled driver", 5));
		ogE.addElement(new OptionsGruppeEintrag("Night Fighters", 5));
		ogE.addElement(new OptionsGruppeEintrag("Ace Gunner", 10));
        ogE.addElement(new OptionsGruppeEintrag("Disciplined Crew", 10));
		ogE.addElement(new OptionsGruppeEintrag("Gung-ho! Crew", 5));
		ogE.addElement(new OptionsGruppeEintrag("Battle Hardened Crew", 10));
		ogE.addElement(new OptionsGruppeEintrag("Veteran Commander", 10));
		ogE.addElement(new OptionsGruppeEintrag("Slick Loader", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		sizeSetzen();
	}

    @Override
	public void refreshen() {
        o1.alwaysSelected();
        o1.setAktiv("Slick Loader", this.slickLoader);

        if(this.slickLoader) {
            o1.setMaxAnzahl(this.multiple ? 8 : 1);
        } else {
            o1.setMaxAnzahl(this.multiple ? 7 : 1);
        }

        if(this.multiple) {
            o1.setLegal(o1.isSelected());
        } else {
            o1.setLegal(o1.isSelected() && o1.getAnzahl() < 2);
        }
	}

    @Override
    public void switchEntry(String name, boolean aktiv) {
        if(name.equals("SLICKLOADER")) {
            this.slickLoader = aktiv;
            //this.refreshen();
        }
        if(name.equals("MULTIPLE")) {
            this.multiple = aktiv;
            //this.refreshen();
        }
    }

    @Override
    public Object getSpecialValue() {
        Boolean isLegal = o1.isLegal();
        return isLegal;
    }

}

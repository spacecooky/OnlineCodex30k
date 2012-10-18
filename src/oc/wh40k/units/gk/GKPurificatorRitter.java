package oc.wh40k.units.gk;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class GKPurificatorRitter extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;

	public GKPurificatorRitter() {
		grundkosten = 0;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Psischwert", "Nemesis-Psischwert", 0));
		ogE.addElement(new OptionsGruppeEintrag("Psihellebarde", "Nemesis-Psihellebarde", 2));
		ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Falchions", "Paar Nemesis-Falchions", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhaftes Psischwert", "Meisterhafte Nemesis-Psischwert", 5));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafte Psihellebarde", "Meisterhafte Nemesis-Psihellebarde", 7));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Däm.hammer", "Meisterhafter Nemesis-Dämonenhammer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafte Falchions", "Paar Meisterhafte Nemesis-Falchions", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Wehrstab", "Nemesis-Wehrstab", 25));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Wehrstab", "Meisterhafter Nemesis-Wehrstab", 30));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Meisterhafter Sturmbolter", 5));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();
        
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Digitalwaffen", 5));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0, true);
        o1.setAktiv(!o2.isSelected());

        if(!o3.isSelected()) o3.setSelected(0, true);
	}

	@Override
	public void switchEntry(String name, boolean aktiv) {
		if(name.equals("WEHRSTAB")) {
			o2.setAktiv(aktiv);
		}
	}
    
    @Override
    public Object getSpecialValue() {
        return o2.isSelected() ? Boolean.TRUE : Boolean.FALSE;
    }

}

package oc.wh40k.units.ta;

import oc.OptionsEinzelUpgradeUnique;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsUpgradeGruppeUnique;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class TAKampfanzugKammer extends RuestkammerVater {

	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppeUnique o2u;
	OptionsUpgradeGruppe o3;
	OptionsUpgradeGruppeUnique o3u;
	OptionsZaehlerGruppe o4;
    OptionsEinzelUpgradeUnique oeu1;
    OptionsEinzelUpgradeUnique oeu2;
    OptionsUpgradeGruppe o5;
	boolean[] defaults;

	public TAKampfanzugKammer() {
		grundkosten = 25;
	}

	@Override
	public void initButtons(boolean... defaults) {
		this.defaults = defaults;

		if(defaults[2]) {
			ogE.addElement(new OptionsGruppeEintrag("XV81 Kampfanzug[Forgeworld]", 20));
			ogE.addElement(new OptionsGruppeEintrag("XV84 Kampfanzug[Forgeworld]", 15));
			ogE.addElement(new OptionsGruppeEintrag("XV89 Kampfanzug[Forgeworld]", 25));
			add(o5 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE));
			
			seperator();
		}
		if(defaults[1]) {
            add(oeu1 = new OptionsEinzelUpgradeUnique(ID, randAbstand + 10, cnt, "", "Streugranatwerfer", 20));
            add(oeu2 = new OptionsEinzelUpgradeUnique(ID, randAbstand + 10, cnt, "", "Ionenblaster", 15));
		}
		ogE.addElement(new OptionsGruppeEintrag("Pulskanone", 8, 12));
		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 4, 6));
		ogE.addElement(new OptionsGruppeEintrag("Fusionsblaster", 12, 18));
		ogE.addElement(new OptionsGruppeEintrag("Raketenmagazin", 12, 18));
		ogE.addElement(new OptionsGruppeEintrag("Plasmabeschleuniger", 20, 30));
		add(o1 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 3));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Stabilisatorsystem", 10));
		ogE.addElement(new OptionsGruppeEintrag("Nachtsichtgerät", 3));
		ogE.addElement(new OptionsGruppeEintrag("Drohnencontroller", 0));
		ogE.addElement(new OptionsGruppeEintrag("Feuerleitsystem", 5));
		ogE.addElement(new OptionsGruppeEintrag("Schildgenerator", 20));
		ogE.addElement(new OptionsGruppeEintrag("Multiple Zielerfassung", 5));
		ogE.addElement(new OptionsGruppeEintrag("Verbesserte Zielerfassung", 10));
        add(o2 = new OptionsUpgradeGruppe(0, randAbstand, cnt, "", ogE, 3));

        if(defaults[1]) {
			ogE.addElement(new OptionsGruppeEintrag("Peilmarker", 15));
			ogE.addElement(new OptionsGruppeEintrag("Kommando-Kontroll-Modul", 10));
			ogE.addElement(new OptionsGruppeEintrag("Schubumkehrdüsen", 10));
            add(o2u = new OptionsUpgradeGruppeUnique(ID, randAbstand, cnt, "", ogE, 0));
        }

		if(defaults[0]) {
			cnt = randAbstand;
            ogE.clear();

			ogE.addElement(new OptionsGruppeEintrag("Zeremoniendolch", 5));
			ogE.addElement(new OptionsGruppeEintrag("Kyb. Nachtsichtgerät", 3));
			ogE.addElement(new OptionsGruppeEintrag("Kyb. Drohnencontroller", 0));
			ogE.addElement(new OptionsGruppeEintrag("Kyb. Feuerleitsystem", 5));
			ogE.addElement(new OptionsGruppeEintrag("Kyb. multiple Zielerfassung", 5));
			add(o3 = new OptionsUpgradeGruppe(0, randAbstand + 280, cnt, "", ogE, 100));

			if(defaults[1]) {
				ogE.addElement(new OptionsGruppeEintrag("Stimulanzinjektor", 10));
				ogE.addElement(new OptionsGruppeEintrag("Fluchtsystem", 15));
				ogE.addElement(new OptionsGruppeEintrag("Selbstzerstörungssystem", 15));
				ogE.addElement(new OptionsGruppeEintrag("Iridiumpanzerung", 20));
                add(o3u = new OptionsUpgradeGruppeUnique(ID, randAbstand + 280, cnt, "", ogE, 100));
			}
		}

		seperator();

        ogE.clear();
		ogE.addElement(new OptionsGruppeEintrag("Angriffsdrohne", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schilddrohne", 15));
		ogE.addElement(new OptionsGruppeEintrag("Markerdrohne", 30));
		add(o4 = new OptionsZaehlerGruppe(0, randAbstand + (defaults[0] ? 280 : 0), cnt, "", ogE, 2));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
        boolean wargearLimit = false;
        if(o3u != null) {
            wargearLimit = o4.getKosten() + (defaults[0] ? o3.getKosten() + o3u.getKosten() : 0) <= 100;
        } else {
            wargearLimit = o4.getKosten() + (defaults[0] ? o3.getKosten() : 0) <= 100;
        }

        // Maximale Anzahl an waehlbaren Gegenstaenden mit Beruecksichtigung fuer experimentelle (einzigartige) Systeme
        if(o2u != null) {
            o2.setMaxAnzahl(3 - o2u.getAnzahl());
            o2u.setMaxAnzahl(3 - o2.getAnzahl());
        }

        if(defaults[0]) {
            o3.setLegal(wargearLimit);
            if(o3u != null) o3u.setLegal(wargearLimit);

            if(o3u != null) o3.setMaxAnzahl((int)(100 - o4.getKosten() - o3u.getKosten()));
            if(o3u != null) o3u.setMaxAnzahl((int)(100 - o4.getKosten() - o3.getKosten()));

            o3.setPunkteLimitGruppe(true);
            if(o3u != null) o3u.setPunkteLimitGruppe(true);

            o3.setErhoehbar(wargearLimit);
            if(o3u != null) o3u.setErhoehbar(wargearLimit);

            if(o3u != null) o4.setMaxKosten((int)(100 - o3.getKosten() - o3u.getKosten()));
            else o4.setMaxKosten((int)(100 - o3.getKosten()));
        }

        o4.setErhoehbar(wargearLimit);

        int oeu1count = oeu1 == null ? 0 : oeu1.isSelected() ? 1 : 0;
        int oeu2count = oeu2 == null ? 0 : oeu2.isSelected() ? 1 : 0;
        o1.setButtonMaxAnzahl(2 - oeu1count - oeu2count);

        boolean slotsVoll = false;
        if(o2u != null) {
        	if(o5 !=null){
        		if(o5.isSelected(0)){
        			slotsVoll = o1.getAnzahl() + oeu1count + oeu2count + o2.getAnzahl() + o2u.getAnzahl() == 2;
        		} else{
        			slotsVoll = o1.getAnzahl() + oeu1count + oeu2count + o2.getAnzahl() + o2u.getAnzahl() == 3;
        		}
        		
        		o2.setAktiv(5, !o5.isSelected(1));
        		o3u.setAktiv("Iridiumpanzerung", !o5.isSelected(2));
        		
        	}else{
        		slotsVoll = o1.getAnzahl() + oeu1count + oeu2count + o2.getAnzahl() + o2u.getAnzahl() == 3;
        	}
        } else {
            slotsVoll = o1.getAnzahl() + oeu1count + oeu2count + o2.getAnzahl() == 3;
        }

		o1.setErhoehbar(!slotsVoll);
		o1.setLegal(slotsVoll);
		if(oeu1 != null) oeu1.setLegal(slotsVoll);
		if(oeu1 != null) oeu2.setLegal(slotsVoll);
		o2.setLegal(slotsVoll);
		o2.setErhoehbar(!slotsVoll);
        if(o2u != null) {
            o2u.setLegal(slotsVoll);
            o2u.setErhoehbar(!slotsVoll);
        }

		if(slotsVoll) {
			o2.setLegal("Drohnencontroller", o4.isSelected() || (!o2.isSelected("Drohnencontroller")));
		}

		o4.setLegal(!o4.isSelected() || (o2.isSelected("Drohnencontroller")) && wargearLimit);

		if(defaults[0] && o3.isSelected("Kyb. Drohnencontroller")) {
			o4.setLegal(wargearLimit);
			o3.setLegal("Kyb. Drohnencontroller", o4.isSelected() && wargearLimit);
		}

		setButtonState(slotsVoll && wargearLimit);
	}

}

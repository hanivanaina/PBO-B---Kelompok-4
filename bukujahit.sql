PGDMP     1    "                y         	   bukujahit    13.2    13.2     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    26003 	   bukujahit    DATABASE     l   CREATE DATABASE bukujahit WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Indonesian_Indonesia.1252';
    DROP DATABASE bukujahit;
                postgres    false            �            1259    26050    pesanan    TABLE     M  CREATE TABLE public.pesanan (
    id_pesanan integer NOT NULL,
    id_pelanggan character varying(20) NOT NULL,
    id_baju character varying(5),
    id_celana character varying(5),
    id_rok character varying(5),
    tgl_pesan character varying(20),
    tgl_ambil character varying(20),
    status_pesanan character varying(50)
);
    DROP TABLE public.pesanan;
       public         heap    postgres    false            �            1259    26048    pesanan_id_pesanan_seq    SEQUENCE     �   CREATE SEQUENCE public.pesanan_id_pesanan_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 -   DROP SEQUENCE public.pesanan_id_pesanan_seq;
       public          postgres    false    208            �           0    0    pesanan_id_pesanan_seq    SEQUENCE OWNED BY     Q   ALTER SEQUENCE public.pesanan_id_pesanan_seq OWNED BY public.pesanan.id_pesanan;
          public          postgres    false    207            3           2604    26053    pesanan id_pesanan    DEFAULT     x   ALTER TABLE ONLY public.pesanan ALTER COLUMN id_pesanan SET DEFAULT nextval('public.pesanan_id_pesanan_seq'::regclass);
 A   ALTER TABLE public.pesanan ALTER COLUMN id_pesanan DROP DEFAULT;
       public          postgres    false    207    208    208            �          0    26050    pesanan 
   TABLE DATA           }   COPY public.pesanan (id_pesanan, id_pelanggan, id_baju, id_celana, id_rok, tgl_pesan, tgl_ambil, status_pesanan) FROM stdin;
    public          postgres    false    208   �       �           0    0    pesanan_id_pesanan_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.pesanan_id_pesanan_seq', 6, true);
          public          postgres    false    207            5           2606    26055    pesanan pesanan_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.pesanan
    ADD CONSTRAINT pesanan_pkey PRIMARY KEY (id_pesanan);
 >   ALTER TABLE ONLY public.pesanan DROP CONSTRAINT pesanan_pkey;
       public            postgres    false    208            �   �   x�3�00��B e`�oh�od`d�i�`��'fr�A�q�"�Z`(5*5+�m`W`�i�	P�	�P a�0�tJ�)�UH��N-�J�N��2�1�Zr���x<z̀z�8�V��1í'F��� t�>K     
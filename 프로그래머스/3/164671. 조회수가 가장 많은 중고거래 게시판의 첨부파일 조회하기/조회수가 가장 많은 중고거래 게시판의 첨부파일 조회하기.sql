SELECT CONCAT("/home/grep/src/",file.board_id, "/",file.file_id,file.file_name,file.file_ext) as FILE_PATH
FROM USED_GOODS_FILE file
JOIN USED_GOODS_BOARD board ON file.board_id = board.board_id
WHERE board.views = (SELECT MAX(views) FROM USED_GOODS_BOARD)
ORDER BY file.file_id DESC;